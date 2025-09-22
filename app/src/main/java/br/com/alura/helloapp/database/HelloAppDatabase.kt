package br.com.alura.helloapp.database

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import br.com.alura.helloapp.data.Contato
import br.com.alura.helloapp.data.User
import br.com.alura.helloapp.database.converters.Converters
import br.com.alura.helloapp.database.migrations.Migration3TO4

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