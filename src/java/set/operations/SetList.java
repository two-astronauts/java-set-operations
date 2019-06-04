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
    private Node head;
    private Node lastNode;
    private int count; 
    
    public SetList() {
        this.head = null;
        this.lastNode = null;
        this.count = 0;
    }

    public Node getHead() {
        return head;
    }
    
    public int getCount() {
        return count;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isEmpty() {
        return this.head == null;
    }
    
    /**
     * 
     */
    public void empty() {
        this.head = null;
        this.lastNode = null;
        this.count = 0;
    }
    
    /**
     * 
     * @param paramData 
     */
    public void add(String paramData) {
        Node data = new Node(paramData);
        if(this.isEmpty()) {
            this.head = data;
        }else{
            this.lastNode.setNextNode(data);
        }
        this.lastNode = data;
        this.count++;
    }
    
    /**
     * 
     * @param paramData
     * @return 
     */
    public boolean delete(String paramData) {
        if(!this.isEmpty()) {
            Node aux = this.head;
            Node previous = null;
            boolean exist = false;
            while(aux != null && !exist) {
                if(aux.getData().equals(paramData)) {
                    exist = true;
                }else {
                    previous = aux;
                    aux = aux.getNextNode();
                }
            }
            if(exist) {
                if(aux == this.head) {
                    this.head = this.getHead().getNextNode();
                }else {
                    previous.setNextNode(aux.getNextNode());
                }
                this.count--;
            }
            return exist;
        }
        return false;
    }
    
    /**
     * 
     * @param paramData
     * @return 
     */
    public int position(String paramData) {
        if(!this.isEmpty()) {
            int count = 0;
            Node aux = this.head;
            while(aux != null) {
                if(aux.getData().equals(paramData)) {
                    return count;
                }else {
                    count++;
                    aux = aux.getNextNode();
                }
            }
            return -0;
        }
        return -0;
    }
    
     /**
     * 
     * @param paramData
     * @return 
     */
    public boolean belongs(String paramData) {
        if(!this.isEmpty()){
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
        if(!this.isEmpty() && !paramSubSet.isEmpty()) {
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
    
    /**
     * 
     * @param paramSet
     * @return 
     */
    public SetList union(SetList paramSet) {
        if(this.isEmpty()) {
           return paramSet;
        }else if(paramSet.isEmpty()) {
           return this;
        }else {
            SetList result = new SetList();
            Node aux = this.head;
            while(aux != null) {
                if(!result.belongs(aux.getData())){
                    result.add(aux.getData());
                }
                aux = aux.getNextNode();
            }
            aux = paramSet.getHead();
            while(aux != null) {
                if(!result.belongs(aux.getData())){
                    result.add(aux.getData());
                }
                aux = aux.getNextNode();
            }
            return result;
        }
    }
    
    /**
     * 
     * @param paramSet
     * @return 
     */
    public SetList intersection(SetList paramSet) {
        SetList result = new SetList();
        if(!this.isEmpty() && !paramSet.isEmpty()) {
            Node aux = this.head;
            while(aux != null) {
                if(paramSet.belongs(aux.getData())){
                    result.add(aux.getData());
                }
                aux = aux.getNextNode();
            }
        }
        return result;
    }
    
    /**
     * 
     * @param paramSet
     * @return 
     */
    public boolean equality(SetList paramSet) {
        if((!this.isEmpty() && !paramSet.isEmpty()) && (this.count == paramSet.getCount())) {
            Node aux = this.head;
            while(aux != null) {
                if(!paramSet.belongs(aux.getData())) {
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
    
    /**
     * 
     * @param paramUniversalSet
     * @return 
     */
    public SetList complement(SetList paramUniversalSet) {
        SetList result = new SetList();
        if(this.isEmpty()) {
            result = paramUniversalSet;
        }else {
            Node aux = paramUniversalSet.getHead();
            while(aux != null) {
                if(!this.belongs(aux.getData())) {
                    result.add(aux.getData());
                }
                aux = aux.getNextNode();
            }
        }
        return result;
    }
    
    /**
     * 
     * @param paramSet
     * @return 
     */
    public SetList difference(SetList paramSet) {
        if(paramSet.isEmpty()) {
            return this;
        }else {
            SetList result = new SetList();
            Node aux = this.head;
            while(aux != null) {
                if(!paramSet.belongs(aux.getData())) {
                    result.add(aux.getData());
                }
            }
            return result;
        }
    }
    
    /**
     * 
     * @param paramSet
     * @return 
     */
    public SetList symmetricDifference(SetList paramSet) {
        if(paramSet.isEmpty()) {
            return this;
        }else if (this.isEmpty()) {
            return paramSet;
        }else {
            SetList result = new SetList();
            Node aux = this.head;
            while(aux != null) {
                if(!paramSet.belongs(aux.getData())) {
                    result.add(aux.getData());
                }
            }
            aux = paramSet.getHead();
            while(aux != null) {
                if(!this.belongs(aux.getData())) {
                    result.add(aux.getData());
                }
            }
            return result;
        }
    }
    
}
