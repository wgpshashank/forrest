/*
 * Copyright 1999-2004 The Apache Software Foundation or its licensors,
 * as applicable.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.forrest.forrestdoc.java.src.symtab;

/**
 * Definition of an array type.  Note that this is not currently used in the
 * cross reference tool, but you would define something like this if you
 * wanted to make the tool complete.
 */
class ArrayDef extends Definition implements TypedDef {

    // ==========================================================================
    // ==  Class Variables
    // ==========================================================================

    /** The base type for the Array */
    private Definition type;

    // ==========================================================================
    // ==  Methods
    // ==========================================================================

    /**
     * Constructor to create a new array type
     * 
     * @param name        
     * @param occ         
     * @param parentScope 
     */
    ArrayDef(String name, // the name of the symbol
             Occurrence occ, // the location of its def
             ScopedDef parentScope) {    // scope containing the def

        super(name, occ, parentScope);

        // System.out.println("new ArrayDef");
    }

    /**
     * return the base type of the array
     * 
     * @return 
     */
    public Definition getType() {
        return type;
    }

    /**
     * Write information about the array to the taglist
     * 
     * @param tagList 
     */
    public void generateTags(HTMLTagContainer tagList) {

        /*
         * out.println(getQualifiedName() + "[]  (Array) " + getDef());
         * listReferences(out);
         */
    }

    /**
     * Resolves references to other symbols used by this symbol
     */
    void resolveTypes() {

        // would need to lookup the base type in the symbol table
    }

    /**
     * Return a String representation of the class
     * 
     * @return 
     */
    public String toString() {
        return "ArrayDef [" + type.getQualifiedName() + "]";
    }

    /**
     * Method getOccurrenceTag
     * 
     * @param occ 
     * @return 
     */
    public HTMLTag getOccurrenceTag(Occurrence occ) {
        return null;
    }
}