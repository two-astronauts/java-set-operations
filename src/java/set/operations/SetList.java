/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java.set.operations;

/**
 *
 * @author User
 */
public class SetList {
    
    Node head;
    
    public SetList() {
        this.head = null;
    }

    public Node getHead() {
        return head;
    }
    
    /**
     * 
     * @param paramData
     * @return 
     */
    public boolean belongs(String paramData) {
        if(this.head != null){
            Node aux;
            aux = this.head;
            while(aux != null) {
                if(aux.getData().equals(paramData)) {
                    aux = null;
                    return true;
                }else {
                    aux = aux.getNextNode();
                }
            }
        }
        return false;
    }
    
    /**
     * 
     * @param paramSubSet
     * @return 
     */
    public boolean subSet(SetList paramSubSet) {
        if(this.head != null && paramSubSet.getHead() != null) {
            Node aux;
            aux = paramSubSet.getHead();
            while(aux != null) {
                if(!this.belongs(aux.getData())) {
                    aux = null;
                    return false;
                }else {
                    aux = aux.getNextNode();
                }
            }
            return true;
        }
        return false;
    }
    
}
