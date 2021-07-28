import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.functions.{approx_count_distinct, avg}
//import spark.implicits._

object SparkDataFrame {
  def main(args: Array[String]) {
    System.setProperty("hadoop.home.dir", "C:\\Users\\Drew\\Downloads\\hadoop-3.2.1")
    val spark = SparkSession
      .builder()
      .appName("Spark SQL basic example")
      .config("spark.master", "local")
      .getOrCreate()

    val df = spark.read.format("csv").option("header","true").load("C:\\Users\\Drew\\Documents\\Scala Projects\\ICP10\\src\\main\\scala\\survey (1).csv")

    //df.write.save("surveySave.parquet")

    //val df2 = df.dropDuplicates()

    //val df3 = df.union(df2)

    //df3.orderBy("Country").show(false)

    //df.groupBy("Treatment").count().show(false)


    //println("df1: ",df.count())
    //println("df2: ",df2.count())

    //df.show()
    //println("df3: ",df3.count())

    //df.join(df2,df("Timestamp") === df2("Timestamp"),"inner").show(false)

    //df.select(approx_count_distinct("state")).show()

    df.createGlobalTempView("survey")

    spark.sql("SELECT * FROM " +
      "(SELECT ROW_NUMBER() OVER (ORDER BY Timestamp ASC) AS rownumber," +
      " * FROM global_temp.survey) AS foo WHERE rownumber = 13;").show()
  }
}
