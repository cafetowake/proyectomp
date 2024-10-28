package proyecto_moviles.uvg.edu.gt.data.di

import proyecto_moviles.uvg.edu.gt.data.source.UserDb
import proyecto_moviles.uvg.edu.gt.domain.repository.UserRepository

object AppDependencies {
    lateinit var userRepository: UserRepository
    lateinit var database: UserDb
}