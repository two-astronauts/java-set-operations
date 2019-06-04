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
public class SetArray {
    private String vector[];
    private int count;
    
    public SetArray() {
        this.vector = new String[10];
        this.count = 0;
    }

    public String[] getVector() {
        return vector;
    }

    public int getCount() {
        return count;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isEmpty() {
        for (String value : this.vector) {
            if(value != null) {
                return false;
            }
        }
        return true;
    }
    
    /**
     * 
     */
    public void empty() {
        this.vector = new String[10];
        this.count = 0;
    }
    
    /**
     * 
     * @param paramData 
     */
    public void add(String paramData) {
        this.vector[this.count] = paramData;
        this.count++;
    }
    
    /**
     * 
     * @param paramData
     * @return 
     */
    public boolean delete(String paramData) {
        if(!this.isEmpty()) {
            String vectorAux[] = new String[10];
            int countAux = 0;
            for (String value : this.vector) {
                if(!value.equals(paramData)) {
                    this.vector[countAux] = value;
                    countAux++;
                }else {
                    this.count--;
                }
            }
            this.vector = vectorAux;
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
            for(int i = 0; i < this.vector.length; i++) {
                if(this.vector[i].equals(paramData)) {
                    return i;
                }
            }
        }
        return -0;
    }
    
    /**
     * 
     * @param paramData
     * @return 
     */
    public boolean belongs(String paramData) {
        if(!this.isEmpty()) {
            for (String value : this.vector) {
                if(value.equals(paramData)) {
                    return true;
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
    public boolean subSet(SetArray paramSubSet) {
        if(!this.isEmpty() && !paramSubSet.isEmpty()) {
            for (String value : paramSubSet.getVector()) {
                if(!this.belongs(value)) {
                    return false;
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
    public SetArray union(SetArray paramSet) {
        if(this.isEmpty()) {
           return paramSet;
        }else if(paramSet.isEmpty()) {
           return this;
        }else {
            SetArray result = new SetArray();
            for (String value : this.vector) {
                if(!result.belongs(value)) {
                    result.add(value);
                }
            }
            for (String value : paramSet.getVector()) {
                if(!result.belongs(value)) {
                    result.add(value);
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
    public SetArray intersection(SetArray paramSet) {
        SetArray result = new SetArray();
        if(!this.isEmpty() && !paramSet.isEmpty()) {
            for (String value : this.vector) {
                if(paramSet.belongs(value)) {
                    result.add(value);
                }
            }
        }
        return result;
    }
    
    /**
     * 
     * @param paramSet
     * @return 
     */
    public boolean equality(SetArray paramSet) {
        if((!this.isEmpty() && !paramSet.isEmpty()) && (this.count == paramSet.getCount())) {
            for (String value : this.vector) {
                if(!paramSet.belongs(value)) {
                    return false;
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
    public SetArray complement(SetArray paramUniversalSet) {
        SetArray result = new SetArray();
        if(this.isEmpty()) {
            result = paramUniversalSet;
        }else {
            for (String value : paramUniversalSet.getVector()) {
                if(!this.belongs(value)) {
                    result.add(value);
                }
            }
        }
        return result;
    }
    
    /**
     * 
     * @param paramSet
     * @return 
     */
    public SetArray difference(SetArray paramSet) {
        if(paramSet.isEmpty()) {
            return this;
        }else {
            SetArray result = new SetArray();
            for (String value : this.vector) {
                if(!paramSet.belongs(value)) {
                    result.add(value);
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
    public SetArray symmetricDifference(SetArray paramSet) {
        if(paramSet.isEmpty()) {
            return this;
        }else if (this.isEmpty()) {
            return paramSet;
        }else {
            SetArray result = new SetArray();
            for (String value : this.vector) {
                if(!paramSet.belongs(value)) {
                    result.add(value);
                }
            }
            for (String value : paramSet.getVector()) {
                if(!this.belongs(value)) {
                    result.add(value);
                }
            }
            return result;
        }
    }
}
