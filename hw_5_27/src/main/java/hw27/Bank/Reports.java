package hw27.Bank;

public enum Reports {
    WITHDRAW("Clients: name - %s, has withdrew his money, sum - %d, in the window %d. Money of the window - %d\n\n"),
    DEPOSIT("Clients: name - %s, has deposited his money, sum - %d, in the window %d. Money of the window - %d\n\n");


    private final String report;

    Reports(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }
}

