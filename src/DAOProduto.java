package DAO;

import model.ModelProduto;
import conexoes.ConexaoMySql;
import java.util.ArrayList;

public class DAOProduto extends ConexaoMySql {


    public int salvarProdutoDAO(ModelProduto pModelProduto){
        try {
            this.conectar();
            return this.insertSQL(
                "INSERT INTO tab_Produto ("
                    + "pk_prod_id,"
                    + "produto_desc,"
                    + "produto_quant,"
                    + "produto_double"
                + ") VALUES ("
                    + "'" + pModelProduto.getProdID() + "',"
                    + "'" + pModelProduto.getProdutoDesc() + "',"
                    + "'" + pModelProduto.getProdutoQuant() + "',"
                    + "'" + pModelProduto.getProdutoDouble() + "'"
                + ");"
            );
        }catch(Exception e){
            e.printStackTrace();
            return 0;
        }finally{
            this.fecharConexao();
        }
    }


    public ModelProduto getProdutoDAO(int pProdID){
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_prod_id,"
                    + "produto_desc,"
                    + "produto_quant,"
                    + "produto_double"
                 + " FROM"
                     + " tab_Produto"
                 + " WHERE"
                     + " pk_prod_id = '" + pProdID + "'"
                + ";"
            );

            while(this.getResultSet().next()){
                modelProduto.setProdID(this.getResultSet().getInt(1));
                modelProduto.setProdutoDesc(this.getResultSet().get String(2));
                modelProduto.setProdutoQuant(this.getResultSet().getInt(3));
                modelProduto.setProdutoDouble(this.getResultSet().getDouble(4));
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return modelProduto;
    }


    public ArrayList<ModelProduto> getListaProdutoDAO(){
        ArrayList<ModelProduto> listamodelProduto = new ArrayList();
        ModelProduto modelProduto = new ModelProduto();
        try {
            this.conectar();
            this.executarSQL(
                "SELECT "
                    + "pk_prod_id,"
                    + "produto_desc,"
                    + "produto_quant,"
                    + "produto_double"
                 + " FROM"
                     + " tab_Produto"
                + ";"
            );

            while(this.getResultSet().next()){
                modelProduto = new ModelProduto();
                modelProduto.setProdID(this.getResultSet().getInt(1));
                modelProduto.setProdutoDesc(this.getResultSet().get String(2));
                modelProduto.setProdutoQuant(this.getResultSet().getInt(3));
                modelProduto.setProdutoDouble(this.getResultSet().getDouble(4));
                listamodelProduto.add(modelProduto);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            this.fecharConexao();
        }
        return listamodelProduto;
    }


    public boolean atualizarProdutoDAO(ModelProduto pModelProduto){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "UPDATE tab_Produto SET "
                    + "pk_prod_id = '" + pModelProduto.getProdID() + "',"
                    + "produto_desc = '" + pModelProduto.getProdutoDesc() + "',"
                    + "produto_quant = '" + pModelProduto.getProdutoQuant() + "',"
                    + "produto_double = '" + pModelProduto.getProdutoDouble() + "'"
                + " WHERE "
                    + "pk_prod_id = '" + pModelProduto.getProdID() + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }


    public boolean excluirProdutoDAO(int pProdID){
        try {
            this.conectar();
            return this.executarUpdateDeleteSQL(
                "DELETE FROM tab_Produto "
                + " WHERE "
                    + "pk_prod_id = '" + pProdID + "'"
                + ";"
            );
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            this.fecharConexao();
        }
    }
}