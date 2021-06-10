import java.text.DecimalFormat

fun main() {
    //Create all variables needed
    var itemCost: Double = 0.0
    var subTotal: Double = 0.0
    var totalCost: Double = 0.0
    var itemNumber: Int = 0
    var rounded = DecimalFormat("##,###.##")
    val tax = .025
    val tip = .175
    var taxAmount = 0.0
    var tipAmount = 0.0
    var choice: String

    //Welcome screen with user input.  Number of items are totaled and added together
    println("***Welcome to Cadieux's Tip Calcualtor***")
    println("Enter the cost of each item \nand I will total it up for you")
    print("Enter 0 to EXIT")
    println()
    do {
        itemNumber++
        print("Cost of $itemNumber: $")
        itemCost = readLine()!!.toDouble()
        subTotal += itemCost
    } while (itemCost != 0.0)

    //Total is calculated and properly formatted
    subTotal = rounded.format(subTotal).toDouble()
    totalCost = subTotal
    taxAmount = rounded.format(subTotal*tax).toDouble()
    tipAmount = rounded.format(subTotal*tip).toDouble()

    if (subTotal==0.0) { //This only checks for no items entered
        println("Thanks for checking out my tip calculator!")
    }
    else { //Prints out information if 1 or more items
        println("Number of Items: ${itemNumber - 1}")
        println("Subtotal: $$subTotal")
        println("Tax @ 2.5%: $$taxAmount")
    }

    do {
        println("Would you like to add a tip @ 17.5% or $$tipAmount")
        print("(Y)es or (N)o: ")
        choice = readLine()!!.toString()
    }while(choice != "Y" && choice != "N")

    println("Subtotal: $$subTotal")
    if (choice=="Y"){
        println("Tip: $$tipAmount")
        totalCost += tipAmount
        totalCost += taxAmount
    }
    else{
        totalCost += tax
    }
    println("Tax: $$taxAmount")
    println("Total Cost: $$totalCost")
}