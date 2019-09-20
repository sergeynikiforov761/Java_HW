package com.sberbank;

public enum TradeType {
    FX_SPOT {
        public String getString(){
            return "FX_SPOT";
        }
        public Trade CreateTrade(double price){
            FX_SPOT_Trade fx_spot_trade = new FX_SPOT_Trade(getString(),price);
            fx_spot_trade.printTrade();
            return fx_spot_trade;
        }
    },
    BOND{
        public String getString(){
            return "BOND";
        }
        public Trade CreateTrade(double price){
            BOND_Trade bond_trade = new BOND_Trade(getString(),price);
            bond_trade.printTrade();
            return bond_trade;
        }
    },
    COMMODITY_SPOT{
        public String getString(){
            return "COMMODITY_SPOT";
        }
        public Trade CreateTrade(double price){
            COMMODITY_SPOT_Trade commodity_spot_trade = new COMMODITY_SPOT_Trade(getString(),price);
            commodity_spot_trade.printTrade();
            return commodity_spot_trade;
        }
    },
    IR_SWAP{
        public String getString(){
            return "IR_SWAP";
        }
        public Trade CreateTrade(double price){
            IR_SWAP_Trade ir_swap_trade = new IR_SWAP_Trade(getString(),price);
            ir_swap_trade.printTrade();
            return ir_swap_trade;
        }
    },
    DEFAULT{
        public String getString(){
            return "DEFAULT";
        }
        public Trade CreateTrade(double price){
            return new Trade();
        }

    };
    public abstract Trade CreateTrade(double price);
    public abstract String getString();

}
