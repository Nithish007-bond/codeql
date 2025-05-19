import java.sql.DriverManager

object SQLInjectionExample {
  def getUserByName(name: String): Unit = {
    val conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "password")
    val stmt = conn.createStatement()
    val query = s"SELECT * FROM users WHERE name = '$name'" // vulnerable
    val rs = stmt.executeQuery(query)
    while (rs.next()) {
      println(rs.getString("email"))
    }
  }
}
