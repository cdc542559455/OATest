import java.lang.reflect.Array;
import java.util.*;

public class StripeOAmy {

    public static void main(String[] args) {
        List<String> test = new LinkedList<>();
        test.add("CREATE: id=16&amount=800&currency=USD");
        test.add("FINALIZE: id=16&amount=600&currency=USD");
        test.add("PAY: id=16");
        System.out.println(oweCalculation(test));
    }
    private static Map<String, Invoice> invoiceMap;

    public static class Invoice {
        // record the type of currency, amount, status and associated id
        public String currency;
        public int amount;
        public int status;
        public String id;

        //intialize invoice with given type
        public Invoice(String currency, String id, int amount, int status) {
            this.currency = currency;
            this.id = id;
            this.amount = amount;
            this.status = status;
        }
    }


    /*
        @ requires: a list of given actions is not null or size is greater than 0
        @ return: the amount owed money in USA currency
     */

    public static int oweCalculation(List<String> actions) {
        // return 0 if requires doesn't meet
        if (actions == null || actions.size() == 0) {
            return 0;
        }
        int owedMoney = 0;
        invoiceMap = new HashMap<>();

        for(String action: actions) {
            String[] command = action.split(":");
            String[] parameters = command[1].trim().split("&");
            Arrays.sort(parameters);

            // invalid inputs
            if (command.length != 2 && !(parameters.length == 1 ||
                    parameters.length == 3)) continue;

            String option = command[0].trim();

            if (option.equals("CREATE")) {
                owedMoney = create(parameters, owedMoney);
            } else if ( option.equals("FINALIZE")) {
                owedMoney = finalize(parameters, owedMoney);
            } else if ( option.equals("PAY")) {
                owedMoney = pay(parameters, owedMoney);
            }

        }
        return owedMoney;

    }

    /*
        @ requires: a array of String parameters and current owed
        @ return: a current owed amount of currency
     */
    private static int create(String[] parameters, int current) {
        String[] amount = parameters[0].split("=");
        String[] currency = parameters[1].split("=");
        String[] id = parameters[2].split("=");
        // convert it into
        int oweAmount = Integer.parseInt(amount[1]);

        // repeated order create
        if (invoiceMap.containsKey(id[1])) {
            return current;
        }

        // creates invoice
        invoiceMap.put(id[1],
                new Invoice(currency[1], id[1], oweAmount, 0));

        // check if given invoice created by US dollar
        if (currency[1].equals("USD")) {
            current += oweAmount;
        }
        return current;
    }

    /*
        @ requires: a array of String parameters and current owed
        @ return: a current owed amount of currency
     */
    private static int finalize(String[] parameters, int current) {
        String[] amount = parameters[0].split("=");
        String[] currency = parameters[1].split("=");
        String[] id = parameters[2].split("=");

        // return current owed money
        if (!invoiceMap.containsKey(id[1]) ||
                invoiceMap.get(id[1]).status != 0) return current;

        Invoice target = invoiceMap.get(id[1]);
        int adjustAmount = Integer.parseInt(amount[1]);

        // recalculate current amount
        if (target.currency.equals("USD") &&
                currency[1].equals("USD")) {
            current -= target.amount;
            current += adjustAmount;
        }

        // adjust it according to given condition
        target.currency = currency[1];
        target.status = 1;
        target.amount = adjustAmount;

        return current;
    }

    /*
        @ requires: a array of String parameters and current owed
        @ return: a current owed amount of currency
    */
    private static int pay(String[] parameters, int current) {
        String[] id = parameters[0].split("=");

        // check if parameters are valid
        if (!id[0].equals("id") || !invoiceMap.containsKey(id[1]) ||
                invoiceMap.get(id[1]).status !=1) return  current;

        // change bill status
        Invoice target = invoiceMap.get(id[1]);
        target.status = 2;

        // pay the bills
        if (target.currency.equals("USD")) current -= target.amount;

        return current;

    }




}
