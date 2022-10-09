package com.facets.cloud.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Connections {

	@EmbeddedId ConnectionId id;

	public ConnectionId getId() {
		return id;
	}

	public void setId(ConnectionId id) {
		this.id = id;
	}
	
	@Embeddable
	public static class ConnectionId implements Serializable{
		/**
		 * 
		 */
		
		private static final long serialVersionUID = -2717373650950552880L;
		public ConnectionId() {
			super();
		}
		@Column(name = "from_node_id")
		int fromNodeId;
		@Column(name = "to_node_id")
		int toNodeId;
		public int getFromNodeId() {
			return fromNodeId;
		}
		public void setFromNodeId(int fromNodeId) {
			this.fromNodeId = fromNodeId;
		}
		public int getToNodeId() {
			return toNodeId;
		}
		public void setToNodeId(int toNodeId) {
			this.toNodeId = toNodeId;
		}
		@Override
		public int hashCode() {
			return Objects.hash(fromNodeId, toNodeId);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ConnectionId other = (ConnectionId) obj;
			return fromNodeId == other.fromNodeId && toNodeId == other.toNodeId;
		}
	}
}


