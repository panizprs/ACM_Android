package com.workshop.sample.kotlin.homework


fun getCitiesListOfCustomers(customers: List<Customer>?): List<City>? {
    return customers?.groupBy {customer ->
        customer.city
    }?.keys?.map {
        it.copy()
    }
}

fun getCustomersCountOfTheCity(city: City, customers: List<Customer>?): Int? {
    return customers?.groupBy {customer ->
        customer.city
    }?.get(city)?.size
}

fun sortCustomersBasedOrders(customers: List<Customer>?): List<Customer>?{
    return customers?.sortedByDescending {customer ->
        customer.orders.size
    }
}

fun getProductsCustomerBuyed(customer: Customer): List<Product>{
    return customer.orders?.flatMap { order ->
        order.products.map { product ->
            Product(name = product.name, price = product.price)
        }
    }.distinct()
}

fun getProductsBoughtAtLeastOneTime(customers: List<Customer>?): List<Product>?{
    return customers?.flatMap { customer ->
        customer.orders?.flatMap { order ->
            order.products.map {product ->
                Product(name = product.name, price = product.price)
            }
        }
    }?.distinct()
}
