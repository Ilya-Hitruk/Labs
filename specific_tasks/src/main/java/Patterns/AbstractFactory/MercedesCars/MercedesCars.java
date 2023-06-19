package Patterns.AbstractFactory.MercedesCars;

public enum MercedesCars {
    SEDAN_MERCEDES {
        @Override
        public MercedesBenz createCar() {
            return new SedanMercedes(221, "Mercedes-Benz E63", 4.0);
        }
    },
    COUPE_MERCEDES {
        @Override
        public MercedesBenz createCar() {
            return new CoupeMercedes(212, "Mercedes-Benz C43 COUPE", 3.0);
        }
    },
    CABRIOLET_MERCEDES {
        @Override
        public MercedesBenz createCar() {
           return new CabrioletMercedes(230, "Mercedes-Benz S53 CABRIOLET", 5.5);
        }
    };

    public abstract MercedesBenz createCar();
}
