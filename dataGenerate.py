import random
teaching_build = ['T1','T2','T3']
dorm = ['A01', 'A02', 'A03', 'B06', 'A15', 'A16']
build_name = ['Righteousness','sincerity','thinking']
club_names = [
    "Starlight Exploration Club",
    "Green Creative Gardening Club",
    "Trendy Electronic Music Club"
]
major = ['M1','M2','M3','M4','M5','M6']
professional_names = [
    "Computer Science",
    "Electrical Engineering",
    "Mechanical Engineering",
    "Biology",
    "Psychology",
    "Chemistry",
]
name1 = ['Mark', 'Julia', 'Benjamin', 'Hannah', 'Andrew', 'Zoe', 'David', 'Natalie', 'Samuel', 'Victoria']
name2 = ['Michael', 'Amy', 'Christopher', 'Emily', 'Daniel', 'Olivia', 'Ryan', 'Ella', 'Jonathan', 'Sophia']
name1_id = []
name2_id = []
university_courses = [
    "Introduction to Computer Science",
    "Calculus I",
    "General Chemistry",
    "English Composition",
    "Introduction to Psychology",
    "Principles of Economics",
]
credit_hours = [3, 4, 4, 3, 3, 3]
colleges = [
    "College of Computer Science",
    "College of Aerospace",
    "College of Business",
    "College of Architecture",
]
#dormitory
for i in range(6):
    id = dorm[i]
    space = random.randint(2000,4000)
    print(f"INSERT INTO dormitory VALUES ('{id}', {space});")
#teaching_building
for i in range(3):
    id = teaching_build[i]
    name = build_name[i]
    classroom_number = random.randint(50,100)
    print(f"INSERT INTO teaching_building VALUES ('{id}', '{name}',{classroom_number});")
#major
for i in range(6):
    id = major[i]
    name = professional_names[i]
    student_number = random.randint(50,500)
    print(f"INSERT INTO major VALUES ('{id}', '{name}', {student_number});")
#teacher
for i in range(10):
    id = f"{random.randint(1980,2010)}{random.randint(100000, 999999)}"
    name2_id.append(id)
    name = name2[i]
    title = random.choice(['tutor','lecturer','associate professor','professor'])
    college_id = f"C{random.randint(1, 4)}"
    print(f"INSERT INTO teacher VALUES ('{id}', '{name}', '{title}', '{college_id}');")
#course
for i in range(6):
    id = "C" + str(i)
    name = university_courses[i]
    credit = credit_hours[i]
    location_id = random.choice(teaching_build)
    teacher_id = name2_id[i]
    print(f"INSERT INTO course VALUES ('{id}', '{name}', '{credit}','{location_id}','{teacher_id}');")
#college
for i in range(4):
    id = "C" + str(i+1)
    name = colleges[i]
    student_number = random.randint(100,1500)
    director = random.choice(name2)
    print(f"INSERT INTO college VALUES ('{id}', '{name}', {student_number},'{director}');")    
#student
for i in range(10):
    id = f"2021{random.randint(100000, 999999)}"
    name1_id.append(id)
    name = name1[i]
    age = random.randint(18, 25)
    sex = random.choice(['Male', 'Female'])
    grade = random.choice(['Freshman', 'Sophomore', 'Junior', 'Senior'])
    phone_number = str(random.randint(1000000000, 9999999999))
    major_id = f"M{random.randint(1, 6)}"
    dormitory_id = random.choice(['A01', 'A02', 'A03', 'B06', 'A15', 'A16'])
    college_id = f"C{random.randint(1, 4)}"
    print(f"INSERT INTO student VALUES ('{id}', '{name}', {age}, '{sex}', '{grade}','{phone_number}', '{major_id}', '{dormitory_id}', '{college_id}');")
#student_club
for i in range(15):
    sid = random.choice(name1_id)
    cid = random.choice(['C0','C1','C2'])
    print(f"INSERT INTO student_club VALUES ('{sid}', '{cid}');")
#club
for i in range(3):
    id = "C" + str(i)
    name = club_names[i]
    president_id = random.choice(name1_id)
    print(f"INSERT INTO club VALUES ('{id}', '{name}','{president_id}');")