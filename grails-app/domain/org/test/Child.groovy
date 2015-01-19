package org.test

import grails.persistence.Entity

/**
 * Created by kruno on 18.01.15..
 */
@Entity
class Child {

    String name

    Parent parent

    static constraints = {
        parent nullable: true
    }
}
