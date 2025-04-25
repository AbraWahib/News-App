package com.abra.newsapp.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.abra.newsapp.domain.model.Source

@ProvidedTypeConverter
class ArticleTypeConverter {
    @TypeConverter
    fun fromSource(source: Source): String {
        return "${source.id},${source.name}"
    }
    @TypeConverter
    fun toSource(source: String): Source {
        val sourceList = source.split(",")
        return Source(sourceList[0], sourceList[1])
    }
}