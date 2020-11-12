public class Fraction implements IFraction {

    private final Integer numerator;
    private final Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        this.numerator = numerator;
        this.denominator = denominator;

        if (denominator == 0) throw new ArithmeticException("Cannot Divide by 0");
    }

    @Override
    public Integer getNumerator() {
        return numerator;
    }

    @Override
    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public IFraction plus(IFraction other) {
        int numerator1 = getNumerator();
        int denominator1 = getDenominator();
        int numerator2 = other.getNumerator();
        int denominator2 = other.getDenominator();

        int spolecnyJmenovatel = denominator1 * denominator2;
        int vysledek = (numerator1 * denominator2) + (numerator2 * denominator1);

        return createNormalised(vysledek, spolecnyJmenovatel);
    }

    @Override
    public IFraction minus(IFraction other) {
        int numerator1 = getNumerator();
        int denominator1 = getDenominator();
        int numerator2 = other.getNumerator();
        int denominator2 = other.getDenominator();

        int spolecnyJmenovatel = denominator1 * denominator2;
        int vysledek = (numerator1 * denominator2) - (numerator2 * denominator1);

        return createNormalised(vysledek, spolecnyJmenovatel);
    }

    @Override
    public IFraction times(IFraction other) {
        int numerator1 = getNumerator();
        int denominator1 = getDenominator();
        int numerator2 = other.getNumerator();
        int denominator2 = other.getDenominator();

        int spolecnyJmenovatel = denominator1 * denominator2;
        int vysledek = (numerator1 * denominator2) * (numerator2 * denominator1);
        return createNormalised(vysledek, spolecnyJmenovatel);

    }

    @Override
    public IFraction dividedBy(IFraction other) {
        public IFraction times(IFraction other) {
            int numerator1 = getNumerator();
            int denominator1 = getDenominator();
            int numerator2 = other.getNumerator();
            int denominator2 = other.getDenominator();

            int spolecnyJmenovatel = denominator1 * denominator2;
            int vysledek = (numerator1 * denominator2) / (numerator2 * denominator1);
            return createNormalised(vysledek, spolecnyJmenovatel);
    }

    public static Fraction createNormalised(Integer numerator, Integer denominator) {
        int gcd = findGreatestCommonDenominator(numerator, denominator);
        int numeratorResult = numerator / gcd;
        int denominatorResult = denominator / gcd;
        return new Fraction(numeratorResult, denominatorResult)
    }

    /**
     * @link https://www.baeldung.com/java-greatest-common-divisor
     */
    private static Integer findGreatestCommonDenominator(Integer i1, Integer i2) {
        if (i1 < i2) return findGreatestCommonDenominator(i2, i1);
        if (i2 == 0) return i1;
        return findGreatestCommonDenominator(i2, i1 % i2);
    }

    private static Integer findLowestCommonMultiple(Integer i1, Integer i2) {
        if (i1 == 0 || i2 == 0) return 0;
        else {
            int gcd = findGreatestCommonDenominator(i1, i2);
            return Math.abs(i1 * i2) / gcd;
        }
    }

    @Override
    public String toString() {
        return "Fraction " + numerator + "|" + denominator;
    }
}
