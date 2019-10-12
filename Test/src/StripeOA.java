import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class StripeOA {

    /*
     * Complete the 'calculate_total_owed' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING_ARRAY actions as parameter.
     */
    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public static class Invoice {
        // marks the type/kind of money received in this invoice
        String moneyKind;
        // marks the status of this invoice: zero signifies being create, one signifies finalized and two signifies getting paid
        int status;
        // marks the amount of money received in this invoice
        int total;
        // marks the id gotten received in this invoice
        String id;
        public Invoice (String curKind, String curid, int curTotal) {
            this.moneyKind = curKind;
            this.id = curid;
            this.total = curTotal;
            // initializes the class to created
            this.status = 0;
        }
    }

    /*

     */
    public static int calculate_total_owed(List<String> actions) {
        // verify for empty actions
        if (actions == null || actions.size() == 0) {
            return 0;
        }
        // stores the amount of the money as result in usd currency
        int sum = 0;
        // stores the present orders onfile
        Map<String, Invoice> invoiceMap = new HashMap<>();
        for (String line : actions) {
            String[] command = line.split(": ");
            // verifies when input equals
            if (command.length == 1 || command.length > 2) {
                continue;
            }
            // signifies the action that this line of command conveys
            String action = command[0];
            if (action.equals("PAY")) {
                // pays the invoice if valid and modifies the amount if needed
                sum = pay(invoiceMap, command, sum);
            } else if (action.equals("CREATE") || action.equals("FINALIZE")) {
                String[] invoice = command[1].split("&");
                // verifiy if input invalid
                if (invoice.length < 3) {
                    continue;
                }
                if (!action.equals("CREATE")) {
                    // finalize the invoice if valid and modifies the amount if needed
                    sum = finalize(invoiceMap, invoice, sum);
                } else {
                    // creates the invoice if valid and modifies the amount if needed
                    sum = create(invoiceMap, invoice, sum);
                }
            }
        }
        return sum;
    }

    // performs logics regarding when paying an invoice
    private static int pay(Map<String, Invoice> invoiceMap, String[] command, int sum) {
        String[] details = command[1].split("=");
        // checks if invalid command, or invoice does not exist or status not as expected
        if (!details[0].equals("id") || !invoiceMap.containsKey(details[1]) || invoiceMap.get(details[1]).status != 1) {
            return sum;
        }
        Invoice finaledInvoice = invoiceMap.get(details[1]);
        finaledInvoice.status = 2;
        invoiceMap.put(details[1], finaledInvoice);
        // decreases by prev dollar $
        if (finaledInvoice.moneyKind.equals("USD")) {
            return sum - finaledInvoice.total;
        } else {
            return sum;
        }
    }

    // performs logics regarding when finalizing an invoice
    private static int finalize(Map<String, Invoice> invoiceMap, String[] invoice, int sum) {
        String[] number = invoice[1].split("=");
        String[] details = invoice[0].split("=");
        String[] moneyType = invoice[2].split("=");
        // verify if orders are duplicated
        if (!invoiceMap.containsKey(details[1]) || invoiceMap.get(details[1]).status != 0) {
            return sum;
        }
        Invoice createdInvoice = invoiceMap.get(details[1]);
        // decreases by prev dollar $
        if (createdInvoice.moneyKind.equals("USD")) {
            sum = sum - createdInvoice.total;
        }
        int money = Integer.parseInt(number[1]);
        createdInvoice.total = money;
        // adds by previous amount $ if it is usd
        if (moneyType[1].equals("USD")) {
            sum = sum + money;
        }
        createdInvoice.moneyKind = moneyType[1];
        createdInvoice.status = 1;
        invoiceMap.put(details[1], createdInvoice);
        return sum;
    }

    // performs logics regarding when creating an invoice
    private static int create(Map<String, Invoice> invoiceMap, String[] invoice, int sum) {
        String[] number = invoice[1].split("=");
        String[] details = invoice[0].split("=");
        String[] moneyType = invoice[2].split("=");
        // verify if it satisfies the create case when duplicate orders are created
        if (invoiceMap.containsKey(details[1])) {
            return sum;
        }
        int numbers = Integer.parseInt(number[1]);
        // creates invoice
        invoiceMap.put(details[1], new Invoice(moneyType[1], details[1], numbers));
        // if money satisfies dollar restraint, adds to the sum
        if (moneyType[1].equals("USD")) {
            sum = sum + numbers;
        }
        return sum;
    }
}

