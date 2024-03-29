##A TinyURL service

## Java

[TinyUrlAlgorithm.java](../../src/main/java/org/learning/javapractice/system_design/TinyUrlAlgorithm.java)

## References

* https://www.educative.io/courses/grokking-the-system-design-interview/m2ygV4E81AR
* https://coursehunters.online/t/educative-io-design-gurus-grokking-the-system-design-interview-part-1
* https://coursehunters.online/t/educative-io-design-gurus-grokking-the-system-design-interview-part-2
* https://coursehunters.online/t/educative-io-design-gurus-grokking-the-system-design-interview-part-3
* https://coursehunters.online/t/educative-io-design-gurus-grokking-the-system-design-interview-part-4
* https://coursehunters.online/t/educative-io-design-gurus-grokking-the-system-design-interview-part-5

## Why do we need URL shortening?

URL shortening is used to create shorter aliases for long URLs. We call these shortened aliases “short links.” Users are redirected to the original URL when they hit these short links. Short links save a lot of space when displayed, printed, messaged, or tweeted. Additionally, users are less likely to mistype shorter URLs.

For example, if we shorten the following URL through TinyURL:

https://www.educative.io/courses/grokking-the-system-design-interview/m2ygV4E81AR
We would get:

https://tinyurl.com/rxcsyr3r
The shortened URL is nearly one-third the size of the actual URL.

URL shortening is used to optimize links across devices, track individual links to analyze audience, measure ad campaigns’ performance, or hide affiliated original URLs.

If you haven’t used tinyurl.com before, please try creating a new shortened URL and spend some time going through the various options their service offers. This will help you a lot in understanding this chapter.

## Requirements and Goals of the System

💡 You should always clarify requirements at the beginning of the interview. Be sure to ask questions to find the exact scope of the system that the interviewer has in mind.
Our URL shortening system should meet the following requirements:

Functional Requirements:

* Given a URL, our service should generate a shorter and unique alias of it. This is called a short link. This link should be short enough to be easily copied and pasted into applications.
* When users access a short link, our service should redirect them to the original link.
* Users should optionally be able to pick a custom short link for their URL.
* Links will expire after a standard default timespan. Users should be able to specify the expiration time.

Non-Functional Requirements:

* The system should be highly available. This is required because, if our service is down, all the URL redirections will start failing.
* URL redirection should happen in real-time with minimal latency.
* Shortened links should not be guessable (not predictable).

Extended Requirements:

* Analytics; e.g., how many times a redirection happened?
* Our service should also be accessible through REST APIs by other services.
