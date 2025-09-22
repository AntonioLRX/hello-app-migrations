package br.com.alura.helloapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    foreignKeys = [ForeignKey(
        User::class,
        parentColumns = ["idUser"],
        childColumns = ["userId"],
        onDelete = CASCADE
    )]
)
data class Contato(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nome: String = "",
    val sobrenome: String = "",
    val telefone: String = "",
    val fotoPerfil: String = "",
    val aniversario: Date? = null,
    @ColumnInfo(defaultValue = "")
    val userId: String = ""
)