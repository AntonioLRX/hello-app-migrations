package br.com.alura.helloapp.database.migrations

import androidx.room.RenameColumn
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_1_2 = object  : Migration(1,2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS User (`userName` TEXT NOT NULL, `password` TEXT NOT NULL, PRIMARY KEY(`userName`))")
    }
}

val MIGRATION_5_6 = object  : Migration(5,6) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE IF NOT EXISTS ContatoCopia (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `nome` TEXT NOT NULL, `sobrenome` TEXT NOT NULL, `telefone` TEXT NOT NULL, `fotoPerfil` TEXT NOT NULL, `aniversario` INTEGER, `userId` TEXT NOT NULL DEFAULT '', FOREIGN KEY(`userId`) REFERENCES `User`(`idUser`) ON UPDATE NO ACTION ON DELETE CASCADE )")
        database.execSQL( "INSERT INTO ContatoCopia SELECT * FROM Contato")
        database.execSQL("DROP TABLE Contato")
        database.execSQL("ALTER TABLE ContatoCopia RENAME TO Contato")
    }
}


@RenameColumn(
    tableName = "User",
    fromColumnName = "userName",
    toColumnName = "idUser"
)
class Migration3TO4 : AutoMigrationSpec