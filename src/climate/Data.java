package climate;

/**
 * Contains the Data object, which
 * stores all the necessart items extracted
 * from every line read in the CSV file
 * 
 * @author Navya Sharma
 */

public class Data {
  public double prcntAfricanAmerican;
  public double prcntNative;
  public double prcntAsian;
  public double prcntWhite;
  public double prcntHispanic;
  public String disadvantaged;
  public double PMlevel;
  public double chanceOfFlood;
  public double prcntPovertyLine;

  /**
   * Data constructor: initializes default values
   */
  public Data() {
    this.prcntAfricanAmerican = 0.0;
    this.prcntNative = 0.0;
    this.prcntAsian = 0.0;
    this.prcntWhite = 0.0;
    this.prcntHispanic = 0.0;
    this.disadvantaged = null;
    this.PMlevel = 0.0;
    this.chanceOfFlood = 0.0;
    this.prcntPovertyLine = 0.0;

  }

  /**
   * Parameterized constructor: accepts parameters that form the Data object
   * and store info for this community.
   * 
   * @param prcntAfricanAmerican holds value of corresponding % field in CSV, as
   *                             a double
   * @param prcntNative          holds value of corresponding % field in CSV, as
   *                             a double
   * @param prcntAsian           holds value of corresponding % field in CSV, as
   *                             a double
   * @param prcntWhite           holds value of corresponding % field in CSV, as
   *                             a double
   * @param prcntHispanic        holds value of corresponding % field in CSV, as
   *                             a double
   * @param disadvantaged        holds value of corresponding field in CSV, as
   *                             a String (TRUE/FALSE)
   * @param PMlevel              holds value of corresponding PM level field in
   *                             a CSV, as double
   * @param chanceOfFlood        holds value of corresponding field in CSV, as
   *                             a double
   * @param povertyLine          holds value of corresponding field in CSV, as
   *                             a double
   */
  public Data(double prcntAfricanAmerican, double prcntNative, double prcntAsian,
      double prcntWhite, double prcntHispanic, String disadvantaged,
      double PMlevel, double chanceOfFlood, double povertyLine) {
    this.prcntAfricanAmerican = prcntAfricanAmerican;
    this.prcntNative = prcntNative;
    this.prcntAsian = prcntAsian;
    this.prcntWhite = prcntWhite;
    this.prcntHispanic = prcntHispanic;
    this.disadvantaged = disadvantaged;
    this.PMlevel = PMlevel;
    this.chanceOfFlood = chanceOfFlood;
    this.prcntPovertyLine = povertyLine;
  }
  // getter and setter methods

  /**
   * Obtains the percentage of African Americans in this Data object
   * 
   * @return the corresponding percentage, as double
   */
  public double getPrcntAfricanAmerican() {
    return this.prcntAfricanAmerican;
  }

  /**
   * Updates the percentage of African Americans in this Data object
   * 
   * @param prcntAfricanAmerican the corresponding percentage to update, as double
   */
  public void setPrcntAfricanAmerican(double prcntAfricanAmerican) {
    this.prcntAfricanAmerican = prcntAfricanAmerican;
  }

  /**
   * Obtains the percentage of Native Americans stored in this Data object
   * 
   * @return the corresponding percentage, as double
   */
  public double getPrcntNative() {
    return this.prcntNative;
  }

  /**
   * Updates the percentage of African Americans in this Data object
   * 
   * @param prcntNative the corresponding percentage to update, as double
   */
  public void setPrcntNative(double prcntNative) {
    this.prcntNative = prcntNative;
  }

  // set and get percent Asian Americans

  /**
   * Obtains the percentage of Asian Americans stored in this Data object
   * 
   * @return the corresponding percentage, as double
   */
  public double getPrcntAsian() {
    return this.prcntAsian;
  }

  /**
   * Updates the percentage of Asian Americans in this Data object
   * 
   * @param prcntAsian the corresponding percentage to update, as double
   */
  public void setPrcntAsian(double prcntAsian) {
    this.prcntAsian = prcntAsian;
  }

  /**
   * Obtains the percentage of White Americans stored in this Data object
   * 
   * @return the corresponding percentage, as double
   */
  public double getPrcntWhite() {
    return this.prcntWhite;
  }

  /**
   * Updates the percentage of White Americans in this Data object
   * 
   * @param prcntWhite the corresponding percentage to update, as double
   */
  public void setPrcntWhite(double prcntWhite) {
    this.prcntWhite = prcntWhite;
  }

  /**
   * Obtains the percentage of Hispanic Americans stored in this Data object
   * 
   * @return the corresponding percentage, as double
   */
  public double getPrcntHispanic() {
    return this.prcntHispanic;
  }

  /**
   * Updates the percentage of Hispanic Americans stored in this Data object
   * 
   * @param prcntHispanic the corresponding percentage to update, as double
   */
  public void setPrcntHispanic(double prcntHispanic) {
    this.prcntHispanic = prcntHispanic;
  }

  /**
   * Updates the advantage status.
   * 
   * @param disadvantaged the corresponding value to update, as String
   */
  public void setAdvantageStatus(String disadvantaged) {
    this.disadvantaged = disadvantaged;
  }

  /**
   * Obtains disadvantaged status (TRUE/FALSE), as reported in String value from
   * this CSV
   * 
   * @return the corresponding value, as String
   */
  public String getAdvantageStatus() {
    return disadvantaged;
  }

  /**
   * Updates particulate matter (PM) levels, as reported in parameter
   * 
   * @param PMlevel the corresponding value, as double
   */
  public void setPMlevel(double PMlevel) {
    this.PMlevel = PMlevel;
  }

  /**
   * Obtains PM level stored in this object
   * 
   * @return the value as double
   */
  public double getPMlevel() {
    return PMlevel;
  }

  /**
   * Setter for chance of flood value as reported from CSV
   * 
   * @param flood the new flood chance value to update, as double
   */
  public void setChanceOfFlood(double flood) {
    this.chanceOfFlood = flood;
  }

  /**
   * Getter for chance of flood value as reported from CSV
   * 
   * @return the corresponding value as double
   */
  public double getChanceOfFlood() {
    return chanceOfFlood;
  }

  /**
   * Setter for poverty line % value as reported from CSV
   * 
   * @param povertyLine the new corresponding value as double
   */
  public void setPercentPovertyLine(double povertyLine) {
    this.prcntPovertyLine = povertyLine;
  }

  /**
   * Getter for poverty line % value as reported from CSV
   * 
   * @return the corresponding value as double
   */
  public double getPercentPovertyLine() {
    return prcntPovertyLine;
  }

}
