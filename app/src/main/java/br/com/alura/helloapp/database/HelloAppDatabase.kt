package br.com.alura.helloapp.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RenameColumn
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.AutoMigrationSpec
import br.com.alura.helloapp.data.Contato
import br.com.alura.helloapp.data.User
import br.com.alura.helloapp.database.converters.Converters

@Database(
    entities = [Contato::class, User::class],
    version = 6,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(2, 3),
        AutoMigration(3, 4, Migration3TO4::class),
        AutoMigration(4, 5),
    ]
)
@TypeConverters(Converters::class)
abstract class HelloAppDatabase : RoomDatabase() {
    abstract fun contatoDao(): ContatoDao
    abstract fun userDao(): UserDao
}

@RenameColumn(
    tableName = "User",
    fromColumnName = "userName",
    toColumnName = "idUser"
)
class Migration3TO4 : AutoMigrationSpec