package com.sberbank;

public enum TradeType {
    FX_SPOT {
        public String getString(){
            return "FX_SPOT";
        }
        public void CreateTrade(double price){
            FX_SPOT_Trade fx_spot_trade = new FX_SPOT_Trade(getString(),price);
            fx_spot_trade.printTrade();
        }
    },
    BOND{
        public String getString(){
            return "BOND";
        }
        public void CreateTrade(double price){
            BOND_Trade bond_trade = new BOND_Trade(getString(),price);
            bond_trade.printTrade();
        }
    },
    COMMODITY_SPOT{
        public String getString(){
            return "COMMODITY_SPOT";
        }
        public void CreateTrade(double price){
            COMMODITY_SPOT_Trade commodity_spot_trade = new COMMODITY_SPOT_Trade(getString(),price);
            commodity_spot_trade.printTrade();
        }
    },
    IR_SWAP{
        public String getString(){
            return "IR_SWAP";
        }
        public void CreateTrade(double price){
            IR_SWAP_Trade ir_swap_trade= new IR_SWAP_Trade(getString(),price);
            ir_swap_trade.printTrade();
        }
    },
    DEFAULT{
        public String getString(){
            return "DEFAULT";
        }
        public void CreateTrade(double price){
            System.out.println("No Trade allowed");
        }

    };
    public abstract void CreateTrade(double price);
    public abstract String getString();

}
