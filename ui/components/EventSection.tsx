import React, {FC} from 'react'
import Section from './Section'

interface IEventSection {
    name: string
    type: string
    eventList: any[]
}

const EventSection: FC<IEventSection> = ({name, type, eventList}) => {
    return (
        <Section title={name}>
				<table className="table">
					<thead>
						<tr>
							<th>Title</th>
							<th>Description</th>
							<th>Type</th>
							<th>Date</th>
							<th>Link</th>
						</tr>
					</thead>
					<tbody>
						{eventList.filter(i=>i.eventType == type).map((i) => (
							<tr>
								<td>{i.name}</td>
								<td>{i.description}</td>
								<td>{i.eventType}</td>
								<td>{i.dateTime}</td>
								<td><a href={i.link}>Click</a></td>
							</tr>
						))}
					</tbody>
				</table>
			</Section>
    )
}

export default EventSection