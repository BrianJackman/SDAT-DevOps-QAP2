# SDAT-DevOps-QAP2
# Golf Club API

## Supported Search APIs

### Members
- Search by name: `/api/members/search?name={name}`
- Search by phone: `/api/members/search?phone={phone}`
- Search by start date: `/api/members/search?startDate={startDate}`


### Tournaments
- Search by start date: `/api/tournaments/search?startDate={startDate}`
- Search by location: `/api/tournaments/search?location={location}`
- Find all members in a tournament: `/api/tournaments/{id}/members`
## Prerequisites

- Docker
- Docker Compose

## Running the Project

To run the project in Docker, follow these steps:

1. **Clone the Repository**:
   ```sh
   git clone https://github.com/BrianJackman/SDAT-DevOps-QAP2.git
   cd SDAT-DevOps-QAP2

2. **Build and run the docker containers**
   docker-compose up --build -d
