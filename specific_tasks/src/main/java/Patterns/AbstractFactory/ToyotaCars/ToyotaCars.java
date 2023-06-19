package Patterns.AbstractFactory.ToyotaCars;
public enum ToyotaCars {

    SEDAN_TOYOTA {
        @Override
        public Toyota createCar() {
            return new SedanToyota(155, "Camry", 3.5);
        }
    },
    COUPE_TOYOTA {
        @Override
        public Toyota createCar() {
            return new CoupeToyota(140, "Supra", 3.0);
        }
    },
    CABRIOLET_TOYOTA {
        @Override
        public Toyota createCar() {
            return new CabrioletToyota(110, "Solar", 2.0);
        }
    };

    public abstract Toyota createCar();
}
