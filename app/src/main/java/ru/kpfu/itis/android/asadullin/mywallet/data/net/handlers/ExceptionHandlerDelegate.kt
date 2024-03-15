package ru.kpfu.itis.android.asadullin.data.handlers

import retrofit2.HttpException
import ru.kpfu.itis.android.asadullin.data.handlers.exceptions.BadGatewayException
import ru.kpfu.itis.android.asadullin.data.handlers.exceptions.BadRequestException
import ru.kpfu.itis.android.asadullin.data.handlers.exceptions.ClientErrorException
import ru.kpfu.itis.android.asadullin.data.handlers.exceptions.InternalServerErrorException
import ru.kpfu.itis.android.asadullin.data.handlers.exceptions.NotFoundException
import ru.kpfu.itis.android.asadullin.data.handlers.exceptions.ServerErrorException
import ru.kpfu.itis.android.asadullin.data.handlers.exceptions.ServiceUnavailable
import ru.kpfu.itis.android.asadullin.data.handlers.exceptions.TooManyRequestsException
import ru.kpfu.itis.android.asadullin.data.handlers.exceptions.UnauthorizedException
import ru.kpfu.itis.android.asadullin.utils.Constants

class ExceptionHandlerDelegate(
) {

    fun handleException(ex: Exception): Exception {
        return when (ex) {
            is HttpException -> {
                when (ex.code()) {
                    Constants.BAD_REQUEST_STATUS_CODE -> {
                        BadRequestException("There is a syntax error in request.")
                    }

                    Constants.UNAUTHORIZED_STATUS_CODE -> {
                        UnauthorizedException("You should authorize to proceed.")
                    }

                    Constants.NOT_FOUND_STATUS_CODE -> {
                        NotFoundException("There is no such share in Tinkoff Application.")
                    }

                    Constants.TOO_MANY_REQUESTS_STATUS_CODE -> {
                        TooManyRequestsException("Too many requests.")
                    }

                    in Constants.BAD_REQUEST_STATUS_CODE..Constants.MAX_CLIENT_ERROR_STATUS_CODE -> {
                        ClientErrorException("Client error.")
                    }

                    Constants.INTERNAL_SERVER_ERROR_STATUS_CODE -> {
                        InternalServerErrorException("There was an error on server.")
                    }

                    Constants.BAD_GATEWAY_STATUS_CODE -> {
                        BadGatewayException("There is bad gateway.")
                    }

                    Constants.SERVICE_UNAVAILABLE_STATUS_CODE -> {
                        ServiceUnavailable("The service is currently unavailable.")
                    }

                    in Constants.INTERNAL_SERVER_ERROR_STATUS_CODE..Constants.MAX_SERVER_ERROR_STATUS_CODE -> {
                        ServerErrorException("Server error.")
                    }

                    else -> {
                        ex
                    }
                }
            }

            else -> {
                ex
            }
        }
    }

}
