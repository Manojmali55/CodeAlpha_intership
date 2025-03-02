import java.util.*;

class Stock {
    String symbol;
    double price;

    public Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }
}

class Portfolio {
    Map<String, Integer> holdings = new HashMap<>();
    double balance;

    public Portfolio(double balance) {
        this.balance = balance;
    }


    public void buyStock(String symbol, int quantity, double price) {
        double cost = quantity * price;
        if (cost <= balance) {
            balance -= cost;
            holdings.put(symbol, holdings.getOrDefault(symbol, 0) + quantity);
            System.out.println("Purchased " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Insufficient funds to buy " + symbol);
        }
    }

    public void sellStock(String symbol, int quantity, double price) {
        if (holdings.getOrDefault(symbol, 0) >= quantity) {
            holdings.put(symbol, holdings.get(symbol) - quantity);
            balance += quantity * price;
            System.out.println("Sold " + quantity + " shares of " + symbol);
        } else {
            System.out.println("Not enough shares to sell " + symbol);
        }
    }

    public void displayPortfolio() {
        System.out.println("\nPortfolio:");
        System.out.println("Balance: " + balance);
        for (Map.Entry<String, Integer> entry : holdings.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue() + " shares");
        }
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Stock> market = new HashMap<>();
        market.put("TCS", new Stock("TCS", 3475.0));
        market.put("INFOSYS", new Stock("INFOSYS", 1683.50));
        market.put("WIPRO", new Stock("WIPRO", 278.4));

        Portfolio portfolio = new Portfolio(10000);
        /*USING WHILE LOOPS */

        while (true) {
            /*DISPLAY THE DETAILS MENU OF  PLATFORM */
            System.out.println("\nStock Trading Platform:");
            System.out.println("1. View Market Prices");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
               /*USING SWITCH STATEMENT */
            switch (choice) {
                case 1:
                    System.out.println("\nMarket Prices:");
                    for (Stock stock : market.values()) {
                        System.out.println(stock.symbol + " : $" + stock.price);
                    }
                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    String buySymbol = scanner.next();
                    if (market.containsKey(buySymbol)) {
                        System.out.print("Enter quantity: ");
                        int buyQuantity = scanner.nextInt();
                        portfolio.buyStock(buySymbol, buyQuantity, market.get(buySymbol).price);
                    } else {
                        System.out.println("Stock not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = scanner.next();
                    if (market.containsKey(sellSymbol)) {
                        System.out.print("Enter quantity: ");
                        int sellQuantity = scanner.nextInt();
                        portfolio.sellStock(sellSymbol, sellQuantity, market.get(sellSymbol).price);
                    } else {
                        System.out.println("Stock not found!");
                    }
                    break;
                case 4:
                    portfolio.displayPortfolio();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
