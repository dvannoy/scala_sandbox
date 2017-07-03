package spark

/**
  * Created by dustinvannoy on 7/3/17.
  */
package object examples {
  case class VehicleStop(stopId: String,
                         stopCause: String,
                        serviceArea: String,
                         subjectRace: String,
                         subjectSex: String,
                         subjectAge: String,
                         timestamp: String,
                         stopDate: String,
                         stopTime: String,
                         sdResident: String,
                         arrested: String,
                         searched: String,
                         obtainedConsent: String,
                         contrabandFound: String,
                         propertySeized: String
    )

  case class VehicleStopBase(stopId: String,
                         stopCause: String,
                         serviceArea: String,
                         subjectRace: String,
                         subjectSex: String,
                         subjectAge: String,
                         timestamp: String,
                         stopDate: String,
                         stopTime: String
                        )
}
