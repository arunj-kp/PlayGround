package com.aj.playground.functions.functional

/**
 * The method executes the code on the database object (so, execute block does not have any params or return types)
 */
fun transactions(db: Database, execute: (db: Database) -> Unit) {
    try {
        execute(db)
    } finally {
        db.commit()
    }
}

fun Database.transact(execute: (db: Database) -> Unit) {
    try {
        execute(this)
    } finally {
        this.commit()
    }
}

class Database {
    fun startTransaction(){}
    fun commit() {}
}

fun main() {
    transactions(Database()) {
        it.startTransaction()
    }
    Database().transact { db ->
        db.startTransaction()
    }
}