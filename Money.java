public class Money {
    private final long paise;
    private final String currency;

    public Money(long paise, String currency) {
        if (paise < 0)
            throw new IllegalArgumentException("Money cannot be negative, update it in paise");
        if (currency == null || currency.isEmpty())
            throw new IllegalArgumentException("Currency cannot be null");
        this.paise = paise;
        this.currency = currency;
    }

    public static Money rupees(long r) {
        return new Money(r * 100, "INR");
    }

    public Money plus(Money c) {
        if (!currency.equals(c.currency))
            throw new IllegalArgumentException("Money is not equal");
        return new Money(paise + c.paise, "INR");
    }

    public static void main(String[] args) {
        Money savings = new Money(5000, "INR");
        Money current = Money.rupees(50);
        Money Total = savings.plus(current);
        System.out.println(Total.paise);
        // System.out.println(m.paise + m.currency);

        // System.out.println(m.paise);
        // System.out.println(m.paise + m.currency);
    }
}
