package org.test

import org.hibernate.Session

/**
 * Created by kruno on 19.01.15..
 */
class ParentChildTest extends GroovyTestCase {

    void "test parent child"() {
        Parent parent = new Parent()
        parent.name = "Jack"
        parent.save()
        Child child = new Child()
        child.name = "Tom"
        child.save()
        parent.addToChildren(child)

        parent.save()
        child.save()
        Parent.withSession { Session session ->
            session.flush()
            session.clear()
        }

        parent = Parent.load(parent.id)
        child = Child.load(child.id)
        assert parent.children.size() == 1
        assert child.parent

        parent.removeFromChildren(child)
        child.parent = null
        parent.save()
        child.save()
        Parent.withSession { Session session ->
            session.flush()
            session.clear()
        }

        parent = Parent.load(parent.id)
        child = Child.load(child.id)
        assert parent.children.size() == 0
        assert child.parent == null
    }
}
