# Zależności
### app/build.gradle.kts
```
dependencies {
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
}
```
# Tworzenie klasy, DAO i klasy bazy danych
### klasa
```
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "ExampleTable")
public class ExampleTable {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public ExampleTable() {}
}
```
### DAO dla klasy
```
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ExampleDao {
    @Insert
    public void insert(ExampleTable exampleTable);
    @Insert
    public void insert(ExampleTable ... exampleTable);
    @Delete
    public void delete(ExampleTable exampleTable);
    @Update
    public void update(ExampleTable exampleTable);
    @Query("SELECT * FROM ExampleTable")
    public List<ExampleTable> getAllExamples();
    @Query("SELECT * FROM ExampleTable WHERE id = :value")
    public String getExampleTableById();
}
```
### klasa bazy danych
```
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ExampleTable.class}, version = 1)
public abstract class ExampleDatabase extends RoomDatabase {
    public abstract ExampleDao getDao();
}
```
# Zastosowanie
```
ExampleDatabase exampleDatanase = new RoomDatabase.Builder<>(
    getApplicationContext(),
    ExampleDatabase.class,
    "example_db"
).allowMainThreadQueries().build();
```
