package ru.kpfu.itis.android.asadullin.data.handlers.exceptions

open class ServerErrorException(message: String) : Exception(message)
class BadRequestException(message: String) : ServerErrorException(message = message)
class UnauthorizedException(message: String) : ServerErrorException(message = message)
class NotFoundException(message: String) : ServerErrorException(message = message)
class TooManyRequestsException(message: String) : ServerErrorException(message = message)

class InternalServerErrorException(message: String) : ServerErrorException(message = message)
class BadGatewayException(message: String) : ServerErrorException(message = message)
class ServiceUnavailable(message: String) : ServerErrorException(message = message)
