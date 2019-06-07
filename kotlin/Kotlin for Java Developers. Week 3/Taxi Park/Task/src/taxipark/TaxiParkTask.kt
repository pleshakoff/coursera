package taxipark

import kotlin.math.roundToInt

/*
 * Task #1. Find all the drivers who performed no trips.
 */
fun TaxiPark.findFakeDrivers(): Set<Driver> = allDrivers.filter { driver -> trips.none { driver == it.driver } }.toSet()


/*
 * Task #2. Find all the clients who completed at least the given number of trips.
 */
fun TaxiPark.findFaithfulPassengers(minTrips: Int): Set<Passenger> =
        allPassengers.filter { passenger -> trips.count { passenger in it.passengers } >= minTrips }.toSet()

/*
 * Task #3. Find all the passengers, who were taken by a given driver more than once.
 */
fun TaxiPark.findFrequentPassengers(driver: Driver): Set<Passenger> =
        allPassengers.filter { passenger -> trips.count { (passenger in it.passengers) && (it.driver == driver) } > 1 }.toSet()

/*
 * Task #4. Find the passengers who had a discount for majority of their trips.
 */
fun TaxiPark.findSmartPassengers(): Set<Passenger> =
        allPassengers.filter { passenger ->
            val partition = trips.filter { passenger in it.passengers }.partition { it.discount ?: 0.0 > 0 }
            return@filter partition.first.size > partition.second.size
        }.toSet()

/*
 * Task #5. Find the most frequent trip duration among minute periods 0..9, 10..19, 20..29, and so on.
 * Return any period if many are the most frequent, return `null` if there're no trips.
 */
fun TaxiPark.findTheMostFrequentTripDurationPeriod(): IntRange? {

  return  trips.groupBy {
        val i = (it.duration / 10)*10
        IntRange(i, i + 9)
    }.maxBy<IntRange, List<Trip>, Int> { (_, list) ->
        (list.size)
    }?.key

}

/*
 * Task #6.
 * Check whether 20% of the drivers contribute 80% of the income.
 */
fun TaxiPark.checkParetoPrinciple(): Boolean {
    if (trips.isEmpty()) return false

    val sDrivers = (allDrivers.size*0.2).roundToInt()
    val total = trips.sumByDouble {  it.cost }*0.8
    return trips.groupBy({it.driver},{it.cost}).map{(_,list) -> (list.sum())}.sortedByDescending {it}.take(sDrivers).sum()>=total


}