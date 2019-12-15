package com.sberbank;

public enum TradeType {
    FX_SPOT {
        public String getString() {
            return "FX_SPOT";
        }

        public Trade CreateTrade(double price) {
            FxSpotTrade fxSpotTrade = new FxSpotTrade(getString(), price);
            fxSpotTrade.printTrade();
            return fxSpotTrade;
        }
    },
    BOND {
        public String getString() {
            return "BOND";
        }

        public Trade CreateTrade(double price) {
            BondTrade bondTrade = new BondTrade(getString(), price);
            bondTrade.printTrade();
            return bondTrade;
        }
    },
    COMMODITY_SPOT {
        public String getString() {
            return "COMMODITY_SPOT";
        }

        public Trade CreateTrade(double price) {
            CommoditySpotTrade commoditySpotTrade = new CommoditySpotTrade(getString(), price);
            commoditySpotTrade.printTrade();
            return commoditySpotTrade;
        }
    },
    IR_SWAP {
        public String getString() {
            return "IR_SWAP";
        }

        public Trade CreateTrade(double price) {
            IrSwapTrade irSwapTrade = new IrSwapTrade(getString(), price);
            irSwapTrade.printTrade();
            return irSwapTrade;
        }
    },
    DEFAULT {
        public String getString() {
            return "DEFAULT";
        }

        public Trade CreateTrade(double price) {
            return new Trade();
        }

    };

    public abstract Trade CreateTrade(double price);

    public abstract String getString();

}
