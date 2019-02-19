package com.workshop.sample.kotlin.homework

fun getCityThatMostCustomersAreFrom(customers: List<Customer>?): City? {
    return if(customers != null) {
        var cities: MutableMap<City, Int> = HashMap()
        customers.forEach { customer ->
            cities[customer.city] = (cities[customer.city] ?: 0) + 1
        }
//    println(cities)
        cities.maxBy { it.value }?.key
    }
    else
        null
}

fun getCustomerWithMaximumNumberOfOrders(customers: List<Customer>?): Customer? {
    return if(customers != null) {
        var maxOrderNum = 0
        var customerWithMaxOrders: Customer? = null
        customers.forEach { customer ->
            if (customer.orders.size > maxOrderNum) {
                maxOrderNum = customer.orders.size
                customerWithMaxOrders = customer
            }
        }
        return customerWithMaxOrders
    }
    else
        null
}

fun main() {
    var tehran = City("Tehran")
    var esfahan = City("Esfahan")
    var shiraz = City("Shiraz")

    var water = Product("water", 1.0)
    var milk = Product("milk", 1.5)
    var pen = Product("pen", 2.0)
    var pen2 = Product("pen", 3.0)
    var snack = Product("snack", 1.5)
    var snack2 = Product("snack2", 3.0)



    var order1 = Order(listOf(pen, pen2), true)
    var order2 = Order(listOf(pen,water, pen2), true)
    var order3 = Order(listOf(water, snack), true)
    var order4 = Order(listOf(pen, water, snack, milk), true)


    var customers = listOf(Customer("Ali", tehran, listOf(order1,order2)),
        Customer("Reza", tehran, listOf(order1,order3)),
        Customer("Gholam", shiraz, listOf(order1,order3,order4,order4,order3)),
        Customer("AliReza", tehran, listOf(order1,order3, order2)),
        Customer("Gholi", shiraz, listOf(order1,order3,order4,order4,order2)))

//    println(customers[0].name)
//    println(getCityThatMostCustomersAreFrom(customers))
//    println(getCustomerWithMaximumNumberOfOrders(customers))


//  // HW8 test
//    println(getCustomersCountOfTheCity(tehran, customers))
//    println(getCitiesListOfCustomers(customers))
//    println(sortCustomersBasedOrders(customers))
//    println(getProductsCustomerBuyed(customers[0]))
    println(getProductsBoughtAtLeastOneTime(customers))
    
}