---
layout: post
title:  "Jobs & Gates or Torvald & Stallman?"
date:   2019-09-07 3:44:00 -0500
categories: seminar
hidden: true
---
In a time where large firms are constantly competing to raise their bottom line and the battle for every ounce of profit, there does not seem to be an argument for them going out of their way to generate non-proprietary projects. However, the reality is quite the contrary, as we discussed within the class; the remarkable nature of the work by GNU and Stallman is that they have championed basic freedoms of a movement. A movement that is the foundation of much of today’s computing architecture. 

I find myself in awe at how they managed to have such significant forethought in a time of rapid development and a chance for tech fortunes. When one examines the historical leaders of the tech world, it is easy to look to Jobs, Gates and other magnates, but, perhaps the contributions of thought by community members like Torvald and Stallman dwarf that of them. This dichotomy follows the reading on the Cathedral and Bazaar as one can compare the contributions of Stallman and Torvald to that of the Bazaar approach while the notable tech giants are those of the Cathedral.
## Sample Title

<details>
<summary>BTS VAr</summary>
<br>
<ul>
<li>Time Period</li>
<ul>
<li>Year: Year</li>
<li>Quarter: Quarter (1-4)</li>
<li>Month: Month</li>
<li>DayofMonth: Day of Month</li>
<li>DayOfWeek: Day of Week</li>
<li>FlightDate: Flight Date (yyyymmdd)</li>
</ul>
<li>Airline</li>
<ul>
<li>Reporting_Airline: Unique Carrier Code. When the same code has been used by multiple carriers, a numeric suffix is used for earlier users, for example, PA, PA(1), PA(2). Use this field for analysis across a range of years.</li>
<li>DOT_ID_Reporting_Airline: An identification number assigned by US DOT to identify a unique airline (carrier). A unique airline (carrier) is defined as one holding and reporting under the same DOT certificate regardless of its Code, Name, or holding company/corporation.</li>
<li>IATA_CODE_Reporting_Airline	Code assigned by IATA and commonly used to identify a carrier. As the same code may have been assigned to different carriers over time, the code is not always unique. For analysis, use the Unique Carrier Code.</li>
<li>Tail_Number: Tail Number	</li>
<li>Flight_Number_Reporting_Airline: Flight Number</li>
</ul>
 <li>Origin	</li>
<ul>
<li>OriginAirportID: Origin Airport, Airport ID. An identification number assigned by US DOT to identify a unique airport. Use this field for airport analysis across a range of years because an airport can change its airport code and airport codes can be reused.</li>
<li>OriginAirportSeqID: Origin Airport, Airport Sequence ID. An identification number assigned by US DOT to identify a unique airport at a given point of time. Airport attributes, such as airport name or coordinates, may change over time.	</li>
<li>OriginCityMarketID: Origin Airport, City Market ID. City Market ID is an identification number assigned by US DOT to identify a city market. Use this field to consolidate airports serving the same city market.	</li>
<li>Origin: Origin Airport</li>
<li>OriginCityName: Origin Airport, City Name</li>
<li>OriginState: Origin Airport, State Code</li>
<li>OriginStateFips: Origin Airport, State Fips</li>
<li>OriginStateName: Origin Airport, State Name</li>
<li>OriginWac: Origin Airport, World Area Code</li>
</ul>
<li>Destination			</li>
<ul>
<li>DestAirportID: Destination Airport, Airport ID. An identification number assigned by US DOT to identify a unique airport. Use this field for airport analysis across a range of years because an airport can change its airport code and airport codes can be reused.		</li>
<li>DestAirportSeqID: Destination Airport, Airport Sequence ID. An identification number assigned by US DOT to identify a unique airport at a given point of time. Airport attributes, such as airport name or coordinates, may change over time.		</li>
<li>DestCityMarketID: Destination Airport, City Market ID. City Market ID is an identification number assigned by US DOT to identify a city market. Use this field to consolidate airports serving the same city market.		</li>
<li>Dest: Destination Airport		</li>
<li>DestCityName: Destination Airport, City Name		</li>
<li>DestState: Destination Airport, State Code		</li>
<li>DestStateFips: Destination Airport, State Fips		</li>
<li>DestStateName: Destination Airport, State Name		</li>
<li>DestWa: Destination Airport, World Area Code</li>
</ul>
<li>Departure Performance			</li>
<ul>
<li>CRSDepTime: CRS Departure Time (local time: hhmm)		</li>
<li>DepTime: Actual Departure Time (local time: hhmm)		</li>
<li>DepDelay: Difference in minutes between scheduled and actual departure time. Early departures show negative numbers.		</li>
<li>DepDelayMinutes: Difference in minutes between scheduled and actual departure time. Early departures set to 0.		</li>
<li>DepDel15: Departure Delay Indicator, 15 Minutes or More (1=Yes)		</li>
<li>DepartureDelayGroups: Departure Delay intervals, every (15 minutes from <-15 to >180)		</li>
<li>DepTimeBlk: CRS Departure Time Block, Hourly Intervals		</li>
<li>TaxiOut: Taxi Out Time, in Minutes		</li>
<li>WheelsOff: Wheels Off Time (local time: hhmm)</li>
</ul>
<li>Arrival Performance			</li>
<ul>
<li>WheelsOn: Wheels On Time (local time: hhmm)		</li>
<li>TaxiIn: Taxi In Time, in Minutes		</li>
<li>CRSArrTime: CRS Arrival Time (local time: hhmm)		</li>
<li>ArrTime: Actual Arrival Time (local time: hhmm)		</li>
<li>ArrDelay: Difference in minutes between scheduled and actual arrival time. Early arrivals show negative numbers.		</li>
<li>ArrDelayMinutes: Difference in minutes between scheduled and actual arrival time. Early arrivals set to 0.		</li>
<li>ArrDel15: Arrival Delay Indicator, 15 Minutes or More (1=Yes)		</li>
<li>ArrivalDelayGroups: Arrival Delay intervals, every (15-minutes from <-15 to >180)		</li>
<li>ArrTimeBlk: CRS Arrival Time Block, Hourly Intervals</li>
</ul>
</ul>
{% include figure.html %}
<br><br>
</details>

<details>
<summary>OpenFlights Variables</summary>
<br>
<ul>
<li>Airport ID: Unique OpenFlights identifier for this airport.</li>
<li>Name: Name of airport. May or may not contain the City name.</li>
<li>City: Main city served by airport. May be spelled differently from Name.</li>
<li>Country: Country or territory where airport is located. See Countries to cross-reference to ISO 3166-1 codes.</li>
<li>IATA: 3-letter IATA code. Null if not assigned/unknown.</li>
<li>ICAO: 4-letter ICAO code.</li>
<li>Latitude: Decimal degrees, usually to six significant digits. Negative is South, positive is North.</li>
<li>Longitude: Decimal degrees, usually to six significant digits. Negative is West, positive is East.</li>
<li>Altitude: In feet.</li>
<li>Timezone: Hours offset from UTC. Fractional hours are expressed as decimals, eg. India is 5.5.</li>
<li>DST	Daylight savings time. One of E (Europe), A (US/Canada), S (South America), O (Australia), Z (New Zealand), N (None) or U (Unknown). See also: Help: Time</li>
<li>Tz database time zone: Timezone in "tz" (Olson) format, eg. "America/Los_Angeles".</li>
<li>Type: Type of the airport. Value "airport" for air terminals, "station" for train stations, "port" for ferry terminals and "unknown" if not known. In airports.csv, only type=airport is included.</li>
<li>Source: Source of this data. "OurAirports" for data sourced from OurAirports, "Legacy" for old data not matched to OurAirports (mostly DAFIF), "User" for unverified user contributions. In airports.csv, only source=OurAirports is included.</li>
</ul>
 <br><br>
</details>
