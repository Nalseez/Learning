from MovieCritics import critics
from math import sqrt

def similarity_euclidean_distance(prefs, person1, person2):
	# Get the list of shared_items
	shared_items={}
	for item in prefs[person1]:
		if item in prefs[person2]:
			shared_items[item]=1

	# If there are no ratings in common between the two, return 0
	if len(shared_items)==0: return 0

	# Add up the squares of all the differences
	sum_of_squares=sum([pow(prefs[person1][item] - prefs[person2][item], 2)
						for item in prefs[person1] if item in prefs[person2]])

	return 1/(1 + sum_of_squares)

print(similarity_euclidean_distance(critics, 'Nalseez', 'Lisa Rose'))

def similarity_pearson(prefs, person1, person2):
	# Get the list of mutually rated items
	shared_items={}
	for item in prefs[person1]:
		if item in prefs[person2]:
			shared_items[item]=1

	# Find the number of elements
	n = len(shared_items)

	# If there are no ratings in common, return 0
	if n==0: return 0

	# Add up all the preferences
	sum1=sum([prefs[person1][myitem] for myitem in shared_items])
	sum2=sum([prefs[person2][myitem] for myitem in shared_items])

	# Sum up the squares
	sum1Sq=sum([pow(prefs[person1][myitem], 2) for myitem in shared_items])
	sum2Sq=sum([pow(prefs[person2][myitem], 2) for myitem in shared_items])

	# Sum up the products
	productSum=sum([prefs[person1][myitem] * prefs[person2][myitem] for myitem in shared_items])

	# Calculate the Pearson Score
	num=productSum - (sum1 * sum2 / n)
	den = sqrt( (sum1Sq - pow(sum1, 2) / n) * (sum2Sq - pow(sum2, 2) / n))
	if den==0: return 0

	return num/den

print(similarity_pearson(critics, 'Nalseez', 'Lisa Rose'))


def topMatches(prefs, person, n=5, similarityFunction=similarity_pearson):
	scores=[(similarityFunction(prefs, person, otherPerson), otherPerson) for otherPerson in prefs if otherPerson != person]

	# Sort the list so the highest scores appear at the top
	scores.sort()
	scores.reverse()
	return scores[0:n]


print('\nThese are the other people you are considered to be similar with using Pearson Similarity')
print(topMatches(critics, 'Nalseez'))
print('\nThese are the other people you are considered to be similar with using Euclidean Distance Similarity')
print(topMatches(critics, 'Nalseez', similarityFunction=similarity_euclidean_distance))


def getRecommendations(prefs, person, similarityFunction=similarity_pearson):
	totals={}
	simSums={}

	for otherPerson in prefs:
		if person == otherPerson: continue
		similarity = similarityFunction(prefs, person, otherPerson)

		if similarity < 0: continue
		for item in prefs[otherPerson]:
			if item not in prefs[person] or prefs[person][item]==0:
				# Similarity * Score
				totals.setdefault(item,0)
				totals[item] += prefs[otherPerson][item] * similarity

				# Sum similarities
				simSums.setdefault(item,0)
				simSums[item] += similarity

	# Normalize
	rankings = [ (total/simSums[item], item) for item,total in totals.items()]

	# return the sorted list
	rankings.sort()
	rankings.reverse()
	return rankings

print('\nThese are movies youd like to see!')
print(getRecommendations(critics, 'Nalseez'))
print(getRecommendations(critics, 'Nalseez',similarityFunction=similarity_euclidean_distance))


def transformPrefs(prefs):
	result={}
	for person in prefs:
		for item in prefs[person]:
			result.setdefault(item,{})

			result[item][person] = prefs[person][item]
	return result

print(critics)
print(transformPrefs(critics))


print(topMatches(transformPrefs(critics), 'Just My Luck'))