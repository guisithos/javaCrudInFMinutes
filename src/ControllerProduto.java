package controller;

import model.ModelProduto;
import DAO.DAOProduto;
import java.util.ArrayList;

/**
*
* @author Guilherme
*/
public class ControllerProduto {

    private DAOProduto daoProduto = new DAOProduto();

    /**
    * grava Produto
    * @param pModelProduto
    * @return int
    */
    public int salvarProdutoController(ModelProduto pModelProduto){
        return this.daoProduto.salvarProdutoDAO(pModelProduto);
    }

    /**
    * recupera Produto
    * @param pProdID
    * @return ModelProduto
    */
    public ModelProduto getProdutoController(int pProdID){
        return this.daoProduto.getProdutoDAO(pProdID);
    }

    /**
    * recupera uma lista deProduto
    * @param pProdID
    * @return ArrayList
    */
    public ArrayList<ModelProduto> getListaProdutoController(){
        return this.daoProduto.getListaProdutoDAO();
    }

    /**
    * atualiza Produto
    * @param pModelProduto
    * @return boolean
    */
    public boolean atualizarProdutoController(ModelProduto pModelProduto){
        return this.daoProduto.atualizarProdutoDAO(pModelProduto);
    }

    /**
    * exclui Produto
    * @param pProdID
    * @return boolean
    */
    public boolean excluirProdutoController(int pProdID){
        return this.daoProduto.excluirProdutoDAO(pProdID);
    }
}