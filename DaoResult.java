/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Marek
 */
public class DaoResult {
    
    public DaoResult(boolean isError,String message){
    this.isError=isError;
    this.messString=message;
    
    }
    
    public DaoResult(boolean isError,String message, Object obj){
    this.isError=isError;
    this.messString=message;
    this.object=obj;
    
    }
    
    public DaoResult(){
    
    }

     public DaoResult(String message){
    this.messString=message;
    }

    
    private boolean isError=false;
    private String messString;
    private Object object;
    
    
    
    /**
     * @return the isError
     */
    public boolean isIsError() {
        return isError;
    }

    /**
     * @param isError the isError to set
     */
    public void setIsError(boolean isError) {
        this.isError = isError;
    }

    /**
     * @return the messString
     */
    public String getMessString() {
        return messString;
    }

    /**
     * @param messString the messString to set
     */
    public void setMessString(String messString) {
        this.messString = messString;
    }

    /**
     * @return the object
     */
    public Object getObject() {
        return object;
    }

    /**
     * @param object the object to set
     */
    public void setObject(Object object) {
        this.object = object;
    }
    
    
    
}
