package utils;

/**
 * @author Lydia BARAUKOVA
 * @author Virgile FANTAUZZI
 */
public class Lib {

    public static class CookieName {
        public static final String CHOCOLALA = "Chocolala",
                DARK_TEMPTATION = "Dark temptation",
                CHERRY_BLOSSOM = "Cherry blossom";
    }

    public static class Cooking {
        public static final String CRUNCHY = "Crunchy",
                CHEWY = "Chewy";
    }
    public static class Drink {
        public static final String COCA_ZERO = "Coca Zero",
                SPRITE = "Sprite";
    }

    public static class Flavour {
        public static final String VANILLA = "Vanilla",
                CINNAMON = "Cinnamon",
                CHILI = "Chili",
                CHOCOLATE = "Chocolate",
                CHERRY = "Cherry";
    }

    public static class Topping {
        public static final String WHITE_CHOCOLATE = "White chocolate",
                MILK_CHOCOLATE = "Milk chocolate",
                DARK_CHOCOLATE = "Dark chocolate",
                CHERRY_SYRUP = "Cherry syrup",
                MNMS = "M&Ms";
    }

    public static class Mix {
        public static final String MIXED = "Mixed",
                TOPPED = "Topped";
    }

    public static class Dough {
        public static final String PLAIN = "Plain",
                CHOCOLATE = "Chocolate",
                PEANUT_BUTTER = "Peanut butter",
                OATMEAL = "Oatmeal",
                CHERRY_JAM = "Cherry jam";
    }

    public static class ComponentType {
        public static final int DOUGH = 0,
                FLAVOUR = 1,
                TOPPING = 2,
                MIX = 3,
                COOKING = 4;
    }
}
