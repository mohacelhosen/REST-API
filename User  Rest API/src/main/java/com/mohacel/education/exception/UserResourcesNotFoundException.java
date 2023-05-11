package com.mohacel.education.exception;

public class UserResourcesNotFoundException extends RuntimeException{
   String resourceName;
   String fieldName;
   long fieldValue;

   public UserResourcesNotFoundException(String resourceName, String fieldName, long fieldValue){
       super(String.format("%s not found with %s : %s", resourceName,fieldName,fieldValue));
       this.resourceName=resourceName;
       this.fieldName=fieldName;
       this.fieldValue=fieldValue;

   }
}
