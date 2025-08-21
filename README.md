# Programming Paradigms

Health Monitoring Systems

[Here is an article that helps to understand the Adult Vital Signs](https://en.wikipedia.org/wiki/Vital_signs)

[Here is a reference to Medical monitoring](https://en.wikipedia.org/wiki/Monitoring_(medicine))

## Purpose

This project implements a vitals monitoring system for patients.
It continuously checks whether vitals (temperature, pulse, and SPO2) are within safe ranges and reports their status.

Monitoring requires accurate reading and thresholding of the vitals.

## Features 

* Monitors Body Temperature, Pulse Rate, and SPO2.
* Classifies vitals into categories:
  - OK → Within the normal safe range
  - NEAR_MIN / NEAR_MAX → Early warning zone (close to min or max)
  - BELOW_MIN / ABOVE_MAX → Critical alert zone (beyond limits)
* Provides Early Warnings to caregivers before an actual breach happens.
  
## Extension 1: Early Warning(Implemented)

Caregivers need early warnings to act in time, instead of waiting for critical alarms.
We introduce a warning tolerance of 1.5% of the upper limit for each vital.

1.Example: Body Temperature
  Allowed range = 95°F – 102°F
  Tolerance = 1.5% of upper limit (102) = 1.53°F

  Warning Ranges:
  95.0 – 96.53°F → Approaching Hypothermia
  100.47 – 102°F → Approaching Hyperthermia

2.Example: Pulse Rate
  Allowed range = 60 – 100 bpm
  Tolerance = 1.5% of 100 = 1.5 bpm
  Warning Ranges:
  60.0 – 61.5 bpm → Approaching Bradycardia
  98.5 – 100 bpm → Approaching Tachycardia

3.Example: SPO2
  Allowed range = 90% – 100%
  Tolerance = 1.5% of 100 = 1.5%
  Warning Ranges:
  90.0 – 91.5% → Approaching Hypoxemia
  98.5 – 100% → Approaching Hyperoxia

## Tests

  Covers classification into OK, NEAR_MIN, NEAR_MAX, BELOW_MIN, ABOVE_MAX.
  Ensures Early Warning tolerance (1.5%) works for Temperature, Pulse, and SPO2.
  
## The future

- May need new vital signs
- A vendor may provide additional vital readings (e.g., blood pressure)
- Limits may change based on the age of a patient

> Predicting the future requires Astrology!

