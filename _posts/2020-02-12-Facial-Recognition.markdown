---
layout: post
title:  "Facial Recognition: a biased comparison"
date:   2020-02-12 11:15:00 -0500
categories: seminar facial-recognition reflection 
---

In the most recent Senior Seminar discussion on facial recognition, the subject of bias was discussed in depth - from areas of criminal justice to the [findings](https://www.nytimes.com/2018/02/09/technology/facial-recognition-race-artificial-intelligence.html) of Joy Buolamwini and the significant differences in identification rates based on race and gender. The conversation built from this to include the comparison of other techniques such as fingerprinting. In an [article](https://machinelearningmastery.com/introduction-to-deep-learning-for-face-recognition/) by Jason Brownlee, he notes that the facial recognition tools being developed at Facebook are reported to now have achieved a 97.35% successful identification rate on the Labeled Faces in the Wild dataset. This stands out as it begins to near the 98% identification rate stated for fingerprinting. 

This comparison is thought-provoking as it makes one wonder about the difference between these two things. In a way, it feels as though they are different approaches to a similar problem but are they? When you consider fingerprinting it is simply the measuring of characteristics on a finger and then using that to sort through a dataset. This process is known; the developer knows what they are programming and therefore they know when a particular item enters what is expected to exit this box. For example, with the [Harris Edges](https://en.wikipedia.org/wiki/Harris_Corner_Detector) approach to feature identification and the [crossing number approach](https://arxiv.org/pdf/1001.4186.pdf), the features can be extracted from the image of a fingerprint. With development and employment of algorithms of this type, the developer community can use traditional debugging method - such as a debugger. 

This differs from the approaches of facial recognition as the creators rely on a significant amount of training to construct a model on which the recognition will work: this is often called the black box of machine learning as the creators do not know how it is actually working. When one struggles to identify why a model will interpret the way in which something is classified, it becomes significantly harder to conclude if this was a morally right conclusion. 

There could be much debate on this topic among computer scientists to philosophers and everything in between. However, the question must be asked: should we make this technology wait for us to understand it? Can we ever understand it? With the exponential pace of computation, these are the questions that must be answered.
