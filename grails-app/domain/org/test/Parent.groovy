package org.test

import grails.persistence.Entity

/**
 * Created by kruno on 18.01.15..
 */
@Entity
class Parent {

    String name

    List children

    static constraints = {
        name nullable: true
    }

    static hasMany = [
        children: Child
    ]
}
