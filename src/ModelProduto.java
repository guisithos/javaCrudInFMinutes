package model;


public class ModelProduto {

    public int prodID;
    public  String produtoDesc;
    public int produtoQuant;
    public double produtoDouble;

    public ModelProduto(){}

    public void setProdID(int pProdID){
        this.prodID = pProdID;
    }

    public int getProdID(){
        return this.prodID;
    }


    public void setProdutoDesc( String pProdutoDesc){
        this.produtoDesc = pProdutoDesc;
    }

    public  String getProdutoDesc(){
        return this.produtoDesc;
    }


    public void setProdutoQuant(int pProdutoQuant){
        this.produtoQuant = pProdutoQuant;
    }

    public int getProdutoQuant(){
        return this.produtoQuant;
    }


    public void setProdutoDouble(double pProdutoDouble){
        this.produtoDouble = pProdutoDouble;
    }

    public double getProdutoDouble(){
        return this.produtoDouble;
    }

    @Override
    public String toString(){
        return "ModelProduto {" + "::prodID = " + this.prodID + "::produtoDesc = " + this.produtoDesc + "::produtoQuant = " + this.produtoQuant + "::produtoDouble = " + this.produtoDouble +  "}";
    }
}