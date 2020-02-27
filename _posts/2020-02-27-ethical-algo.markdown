---
layout: post
title:  "Algorithms of Bias"
date:   2020-02-27 11:15:00 -0500
categories: seminar algorithms bias
---

In the most recent Seminar discussion, the topic of bias in algorithms was raised as both a point of consideration and debate. This question thought-provoking as it begins to make one wonder where the bias lies. Can code be bias? Is the process by which the code is written a biased process? While both of these things can, undoubtedly, be biased, it is, perhaps, out of the scope of a blog post to cover. Rather, it may be beneficial to narrow the field to an analysis of the Correctional Offender Management Profiling for Alternative Sanctions (COMPAS) systems as noted in (Algorithmic bias detection and mitigation: Best practices and policies to reduce consumer harms)[[https://www.brookings.edu/research/algorithmic-bias-detection-and-mitigation-best-practices-and-policies-to-reduce-consumer-harms/](https://www.brookings.edu/research/algorithmic-bias-detection-and-mitigation-best-practices-and-policies-to-reduce-consumer-harms/)].

  

The article explains the errors of the COMPAS system in that its attempt at classification leads to suggesting that African-Americans are more likely to engage in recidivism. It states

> “In the COMPAS algorithm, if African-Americans are more likely to be
> arrested and incarcerated in the U.S. due to historical racism,
> disparities in policing practices, or other inequalities within the
> criminal justice system, these realities will be reflected in the
> training data and used to make suggestions about whether a defendant
> should be detained.”

Having been fortunate enough to study both Computer Science and Economics at Dickinson College, I found this portion particularly thought-provoking. This prompted me to look into the theory on which the COMPAS system was built. With a quick Google search, one will find the documentation for COMPAS in a manual by the name of (Practitioner’s Guide to COMPAS Core)[[https://assets.documentcloud.org/documents/2840784/Practitioner-s-Guide-to-COMPAS-Core.pdf](https://assets.documentcloud.org/documents/2840784/Practitioner-s-Guide-to-COMPAS-Core.pdf)] The guide explains that there 6 theories on which the model is based: Sub-Culture theory, Social-Learning theory, Control and restraint theory, Sociopathic/Socialization Breakdown Theory, Criminal Opportunity Theory, and Social Strain Theory. Each of these takes on their own level of bias and perception in that they were all developed at different points in history. For example, Sub-Culture is a product of the Chicago School of Gangs. This study grew from the analysis of gangs which suggests that particular groups hold values that are more prone to violence and crime. While this may hold within some instances, this avoids nuances by which people may be observed. Further, the questions must be asked what is the root cause of these tendencies. In a paper I wrote for my economics senior seminar, I explored historical subjugation and exclusion from the perspective of homeownership and its translations to the Great Recession.

> Historically capability deprivations drove communities of color to the
> fringe and vulnerable areas within society and in the economy which
> translated to platforms for exploitations during the GR. Widely known
> as the practice of redlining, the effort to prevent communities of
> color forced them to neighborhoods that were not as desirable and
> failed to appreciate. Rheingold, Fitzpatrick, and Hofeld (2001)
> explain how the practices of discrimination prevented minority
> homeownership from taking hold within the United States. Explaining
> how the backing of racial institutions through the Housing Owners Loan
> Corporation, the authors demonstrate that the support of the program
> created an environment which validated this ideology. In this, they
> describe the categorical housing system which permitted the ranking of
> neighborhoods on value; they continue to note that this led to the
> redlining of these communities and elimination of mortgage access to
> these communities. Sen's (1999) framework follows this action
> demonstrating the absence of the economic facilities and societal
> protections that should have been delivered to these groups throughout
> the Housing Owners Loan Corporation policies rather than the
> discrimination they found. In addition, the SDH framework explains how
> this would be an influence on health by excluding those communities
> deemed undesirable. That is, the freedom of economic accumulation was
> withdrawn from them and, as will be seen, exacerbated vulnerabilities
> during the GR.

By the process explained in the above excerpt, communities of color were repeatedly excluded from necessary opportunities for social gain. Further, if the social theories are based on communities that have been subjected to these exclusions, are they not building a culture that reinforces them? This is only a singular example of what may be considered when properly vetting systems. However, it stands as necessary questions if we are to aim to make ethical and social decisions on the lives of people.
