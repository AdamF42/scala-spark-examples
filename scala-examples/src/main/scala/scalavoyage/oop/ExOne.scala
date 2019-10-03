package scalavoyage.oop

object ExOne extends App {

}

class Novel(name: String, year: Int, author: Writer) {

  def getAuthorAgeAtYearRelease: Int = year - author.year

  def isWrittenBy(author: Writer): Boolean = this.author == author

  def copy(year: Int): Novel = new Novel(this.name, year, this.author)
}

class Writer(name: String, surname: String, val year: Int) {

  def getFullName: String = s"$name $surname"

}

