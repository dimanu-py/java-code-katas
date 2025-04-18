package org.dimanu.tripservice.trip

import org.dimanu.tripservice.exception.UserNotLoggedInException
import org.dimanu.tripservice.user.User
import org.dimanu.tripservice.user.UserSession

class TripService {

    fun getTripsByUser(user: User): List<Trip> {
        var tripList: List<Trip> = ArrayList<Trip>()
        var loggedUser: User? = UserSession.instance.loggedUser
        var isFriend: Boolean = false

        if (loggedUser != null) {
            for (friend in user.friends) {
                if (friend == loggedUser) {
                    isFriend = true
                    break
                }
            }
            if (isFriend) {
                tripList = TripDAO.findTripsByUser(user)
            }
            return tripList
        } else {
            throw UserNotLoggedInException()
        }
    }
}